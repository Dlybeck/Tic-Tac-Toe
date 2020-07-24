/* Zystem is a few simple I/O to help teach computer programming.
 *
 * Chomp copyright 2020 Itty Bitty Computers and released at this time
 * to the public as open source. There are no warranties of any kind.
 */
public class Zystem {                                 // 2020 March 18

 /**
  * A safe (no exceptions) way to compare two strings.
  * Works like compareTo but also works properly with null strings.
  *
  * @param  aStr  The first string to compare
  * @param  xStr  The other string to compare it to
  *
  * @return       -1/0/+1 as aStr<xStr or = or >
  */
  public int SafeCompare(String aStr, String xStr) {
    int whom = 0, az = 0, xz = 0;
    try {
    if (xStr != "") xz++;  if (aStr != "") az++;
    if (az==0) {if (xz>0) whom--;}
    else if (xz==0) whom++;
      else whom = aStr.compareTo(xStr);
    } catch (Exception ex) {whom = 0;}
    return whom;} //~SafeCompare

 /**
  * A safe (no exceptions) way to read a non-blank from the console input.
  * Returns a null character ('\0') if it's a space or less
  *
  * @return       the character read
  */
  public static char ReadLetter() { // gets next non-blank
    int aChar;
    while (true) {
      try {aChar = System.in.read();} catch (Exception e) {break;}
      if (aChar <= 0) return '\0';
      if (aChar > 32) return (char)aChar;}
    return '\0';} //~ReadLetter

 /**
  * A safe (no exceptions) way to read a number from the console input.
  * Returns zero if it's not a number.
  *
  * @return       the number as read
  */
  public static int ReadInt() { // depends on static System.in.read
    int res = 0, sgn = 0, base = 10, digit;
    while (true) {
      try {digit = System.in.read();} catch (Exception e) {digit = 0;}
      if (digit == 45) { // '-'
        if (sgn==0) sgn--;
          else sgn = -sgn;
        continue;}
      if (digit<48) { // not a digit..
        if (sgn==0) continue; // must be leading, ignore it
        break;} // trailing, so done
      if (digit == 120) if (res==0) if (sgn !=0) if (base == 10) { // 'x'
        base = 16;
        continue;}
      if (digit>70) break; // not a digit
      if (digit>64) { // hex digit..
        if (base == 10) break;
        res = res*base+(digit-55);}
      else res = res*base+(digit-48);
      if (sgn==0) sgn++;} //~while
    return res*sgn;} //~ReadInt

 /**
  * A safe (no exceptions) way to read a word from the console input.
  *
  * @return       the word as read
  */
  public static String ReadWord() { // use SafeCompare to compare it
    String aWord = "", aLetter;
    int aChar;
    while (true) {
      try {aChar = System.in.read();} catch (Exception e) {break;}
      if (aChar <= 32) {
        if (aWord == "") continue;
        break;}
      aWord = aWord + (char)aChar;}
    return aWord;} //~ReadWord

  } //~Zystem // (javachomp) (Zy)
