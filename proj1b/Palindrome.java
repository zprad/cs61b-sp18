public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        Deque<Character> d = new ArrayDeque<Character>();
        int l = word.length();
        for (int i = 0; i < l; i++) {
            char ele = word.charAt(i);
            d.addLast(ele);
        }
        return d;
    }

    private boolean isFirstEqualLast(Deque<Character> wordDeque) {
        int l = wordDeque.size();
        if (l == 0 || l == 1) {
            return true;
        }
        char first = wordDeque.removeFirst();
        char last = wordDeque.removeLast();
        return first == last && isFirstEqualLast(wordDeque);
    }

    private boolean isPalindromeRecusive(String word) {
        Deque<Character> c = wordToDeque(word);
        return isFirstEqualLast(c);
    }

    private boolean isPalindromeIterate(String word) {
        Deque<Character> c = wordToDeque(word);
        int s = c.size();
        String reverseWord = "";
        for (int i = 0; i < s; i++) {
            reverseWord += c.removeLast();
        }
        return word.equals(reverseWord);
    }

    public boolean isPalindrome(String word) {
        return isPalindromeRecusive(word);
    }

    private boolean isFirstEqualLast(Deque<Character> wordDeque, CharacterComparator cc) {
        int l = wordDeque.size();
        if (l == 0 || l == 1) {
            return true;
        }
        char first = wordDeque.removeFirst();
        char last = wordDeque.removeLast();
        return cc.equalChars(first, last) && isFirstEqualLast(wordDeque, cc);
    }

    private boolean isPalindromeRecusive(String word, CharacterComparator cc) {
        Deque<Character> c = wordToDeque(word);
        return isFirstEqualLast(c, cc);
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        return isPalindromeRecusive(word, cc);
    }

    private boolean isPalindromeNotUseDeque(String word) {
        int l = word.length();
        String reverseWord = "";
        for (int i = 0; i < l; i++) {
            reverseWord = word.charAt(i) + reverseWord;
        }
        return word.equals(reverseWord);
    }
}
