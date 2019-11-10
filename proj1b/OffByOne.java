public class OffByOne implements CharacterComparator {

    @Override
    public boolean equalChars(char x, char y) {
        int diff = x - y;
        diff = Math.abs(diff);
        return diff == 1;
    }
}
