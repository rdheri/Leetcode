class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxSpeed = 0;
        for(int pile : piles) {
            maxSpeed = Math.max(maxSpeed, pile);
        }

        int minSpeed = 1;

        while (minSpeed < maxSpeed) {
            int mid = minSpeed + ((maxSpeed - minSpeed) / 2);

            if(canEat(piles, h, mid)) {
                maxSpeed = mid;
            }
            else {
                minSpeed = mid + 1;
            }
        }
        return minSpeed;
    }

    private boolean canEat(int [] piles, int h, int speed) {
        int hours = 0;

        for(int pile : piles) {
            int fullHours = pile/speed;
            if(pile%speed != 0) {
                fullHours++;
            }
        hours += fullHours;
    }
    return (hours <= h);
    }
}
