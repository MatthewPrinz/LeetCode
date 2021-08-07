class Solution {
  public static char[][] rotateTheBox(char[][] box) {
    if (box == null && box.length == 0 && box[0].length == 0) {
      return new char[0][0];
    }
    char[][] result = new char[box[0].length][box.length];

    // Rotate the box

    // Transpose the box
    for (int i = 0; i < box.length; i++) {
      for (int j = 0; j < box[0].length; j++) {
        result[j][i] = box[i][j];
      }
    }
    // Reverse the box
    for (int i = 0; i < box[0].length; i++) {
      for (int j = 0; j < (box.length / 2); j++) {
        char temp = result[i][j];
        result[i][j] = result[i][box.length - 1 - j];
        result[i][box.length - 1 - j] = temp;
      }
    }

    // Gravity
    for (int i = 0; i < result[0].length; i++) {
      int stones = 0;
      int obstacleIndex = -1;
      for (int j = 0; j < result.length; j++) {
        if (result[j][i] == '#') {
          result[j][i] = '.';
          stones++;
        }
        if (result[j][i] == '*' || (j == (result.length - 1))) {
          obstacleIndex = j;
          int above = (j == (result.length - 1) && result[j][i] != '*') ? j : j - 1;
          while (stones > 0) {
            result[above][i] = '#';
            stones--;
            above--;
          }
        }
      }
    }
    return result;
  }
}
