package days;

public class Day06 {

    public int extractPacketMarkerIndex(String input) {
        for (int i = 0; i < input.length()-3; i++) {
            String packet = input.substring(i, i + 4);
            if (hasNoDuplicate(packet)) {
                return i + 4;
            }
        }
        return 0;
    }

    public int extractPacketMessageIndex(String input) {
        for (int i = 0; i < input.length()-13; i++) {
            String packet = input.substring(i, i + 14);
            if (hasNoDuplicate(packet)) {
                return i + 14;
            }
        }
        return 0;
    }

    private boolean hasNoDuplicate(String packet) {
        return packet.length() == packet.chars().distinct().count();
    }
}
