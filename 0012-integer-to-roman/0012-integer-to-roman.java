class Solution {
    public String intToRoman(int num) {
        String one[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String ten[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String hundred[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String thousand[]= {"", "M", "MM", "MMM"};
        
        String roman = thousand[num / 1000] + hundred[(num%1000) / 100] + ten[(num%100) / 10] + one[num % 10];
        return roman;
   }
}