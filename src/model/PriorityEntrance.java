package model;

public class PriorityEntrance implements Comparable<PriorityEntrance> {
    private int row;
    private int arrivalNum;
    private int accumulatedMiles;
    private boolean isFirstClass;
    private boolean isSpecialAttention;
    private boolean isThirdAge;

    public PriorityEntrance(int age, int row, int arrivalNum, int accumulatedMiles, boolean isFirstClass, boolean isSpecialAttention) {
        this.row = row;
        this.arrivalNum = arrivalNum;
        this.accumulatedMiles = accumulatedMiles;
        this.isFirstClass = isFirstClass;
        this.isSpecialAttention = isSpecialAttention;
        isThirdAge(age);
    }

    public void isThirdAge(int age) {
        if (age >= 65) {
            this.isThirdAge = true;
        }
    }

    @Override
    public int compareTo(PriorityEntrance o) {
        if (this.isFirstClass && !o.isFirstClass) {
            return 1;
        } else if (!this.isFirstClass && o.isFirstClass) {
            return -1;
        } else if (this.isFirstClass && o.isFirstClass) {
            if (this.isThirdAge && !o.isThirdAge) {
                return 1;
            } else if (!this.isThirdAge && o.isThirdAge) {
                return -1;
            } else if (this.isThirdAge && o.isThirdAge) {
                if (this.accumulatedMiles > o.accumulatedMiles) {
                    return 1;
                } else if (this.accumulatedMiles < o.accumulatedMiles) {
                    return -1;
                } else {
                    if (this.isSpecialAttention && !o.isSpecialAttention) {
                        return 1;
                    } else if (!this.isSpecialAttention && o.isSpecialAttention) {
                        return -1;
                    } else if (this.isSpecialAttention && o.isSpecialAttention) {
                        return Integer.compare(this.arrivalNum, o.arrivalNum);
                    } else {
                        return Integer.compare(this.arrivalNum, o.arrivalNum);
                    }
                }
            } else {
                if (this.isSpecialAttention && !o.isSpecialAttention) {
                    return 1;
                } else if (!this.isSpecialAttention && o.isSpecialAttention) {
                    return -1;
                } else if (this.isSpecialAttention && o.isSpecialAttention) {
                    return Integer.compare(this.arrivalNum, o.arrivalNum);
                } else {
                    return Integer.compare(this.arrivalNum, o.arrivalNum);
                }
            }
        } else {
            if (this.row > o.row) {
                return 1;
            } else if (this.row < o.row) {
                return -1;
            } else {
                return Integer.compare(this.arrivalNum, o.arrivalNum);
            }
        }
    }
}
