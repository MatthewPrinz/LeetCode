class Solution {
    public boolean isRobotBounded(String instructions) {
        // dir = 0 -> N, dir = 1 -> R, dir = 2 -> S, dir = 3 -> L
        int dir = 0, posEW = 0, posNS = 0;
        for (int i = 0; i < instructions.length(); i++) {
            switch (instructions.charAt(i)) {
                case 'G':
                    switch (dir) {
                        case 0:
                            posNS++;
                            break;
                        case 1:
                            posEW++;
                            break;
                        case 2:
                            posNS--;
                            break;
                        case 3:
                            posEW--;
                            break;
                    }
                    break;
                case 'R':
                    dir = ((dir + 1) % 4);
                    break;
                case 'L':
                    dir = ((dir + 3) % 4);
                    break;
            } 
        }
        if (dir != 0 || (posEW == 0 && posNS == 0))
            return true;
        return false;
    }
}