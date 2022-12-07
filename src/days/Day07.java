package days;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Day07 {

    public int sumOfDirectoriesUnder100000(String input) {
        List<Directory> allDirectories = getAllDirectories(input);
        return allDirectories.stream().filter(dir -> dir.size <= 100000).mapToInt(dir -> dir.size).sum();
    }

    public int getSmallestDirectorySizeForUpdate(String input) {
        List<Directory> allDirectories = getAllDirectories(input);
        int requiredSpace = 30_000_000;
        int maxSpace = 70_000_000;
        int freeSpace = maxSpace - allDirectories.get(0).size;

        List<Directory> candidates = new ArrayList<>();
        for (Directory dir : allDirectories) {
            if (freeSpace + dir.size >= requiredSpace) {
                candidates.add(dir);
            }
        }

        return Collections.min(candidates, Comparator.comparing(dir -> dir.size)).size;
    }

    private List<Directory> getAllDirectories(String input) {
        List<String> commandNames = Arrays.stream(input.split("\n")).toList();
        List<Command> commands = commandNames.stream().map(commandName -> new Command(commandName, false)).toList();
        Directory root = new Directory("/", null);
        addAllSubDirsAndFiles(commands, root, 0);
        calcSizes(root, 0); // root directory
        List<Directory> allDirectories = new ArrayList<>();
        allDirectories.add(root);
        addAllDirectories(root, allDirectories);
        return allDirectories;
    }

    private void addAllDirectories(Directory parent, List<Directory> allDirectories) {
        for (Directory dir : parent.childDirs) {
            if (dir.childDirs.isEmpty()) {
                allDirectories.add(dir);
            } else {
                allDirectories.add(dir);
                addAllDirectories(dir, allDirectories);
            }
        }
    }

    private static void calcSizes(Directory directory, int sum) {
        if (directory.childDirs.isEmpty()) {
            for (File file : directory.files) {
                sum += file.size;
            }
            directory.size = sum;
            return;
        }
        for (Directory innerDir : directory.childDirs) {
            calcSizes(innerDir, sum);
            directory.size += innerDir.size;
        }
        for (File file : directory.files) {
            sum += file.size;
        }
        directory.size += sum;
    }

    private void addAllSubDirsAndFiles(List<Command> commands, Directory parent, int index) {
        for (int i = index + 2; i < commands.size(); i++) {
            Command currentCommand = commands.get(i);
            if (isEndOfDirectory(currentCommand.name)) {
                return;
            } else if (isDirectory(currentCommand.name)) {
                String innerDirName = currentCommand.name.split(" ")[1];
                Directory childDir = new Directory(innerDirName, parent);
                parent.childDirs.add(childDir);
                addAllSubDirsAndFiles(commands, childDir, getIndexOfChildDirContent(commands, childDir, i));
            } else if (isFile(currentCommand.name)) {
                String fileName = currentCommand.name.split(" ")[1];
                int fileSize = Integer.parseInt(currentCommand.name.split(" ")[0]);
                parent.files.add(new File(fileName, fileSize));
            }
        }
    }

    private boolean isEndOfDirectory(String currentCommand) {
        return currentCommand.startsWith("$");
    }

    private boolean isDirectory(String currentCommand) {
        return currentCommand.startsWith("dir");
    }

    private boolean isFile(String currentCommand) {
        return Character.isDigit(currentCommand.charAt(0));
    }

    private static int getIndexOfChildDirContent(List<Command> commands, Directory dir, int currentIndex) {
        for (int i = currentIndex; i < commands.size(); i++) {
            Command command = commands.get(i);
            if (command.name.equals("$ cd " + dir.name) && !command.visited) {
                command.visited = true;
                return i;
            }
        }
        return 0;
    }

    static class Directory {
        private final String name;
        private final Directory parentDir;
        private final List<Directory> childDirs = new ArrayList<>();
        private final List<File> files = new ArrayList<>();
        private int size;

        public Directory(String name, Directory parentDir) {
            this.name = name;
            this.parentDir = parentDir;
        }
    }

    static class File {
        private final String name;
        private final int size;

        public File(String name, int size) {
            this.name = name;
            this.size = size;
        }
    }

    static class Command {
        private final String name;
        private boolean visited;

        public Command(String name, boolean visited) {
            this.name = name;
            this.visited = visited;
        }
    }
}
