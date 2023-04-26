package model;

public class PriorityExit implements Comparable<PriorityExit> {
    private int row;
    private int proximity;
    private int arrivalNum;

    public PriorityExit(int row, int proximity, int arrivalNum) {
        this.row = row;
        this.proximity = proximity;
        this.arrivalNum = arrivalNum;
    }

    @Override
    public int compareTo(PriorityExit o) {
        if (this.row > o.row) {
            return 1;
        } else if (this.row < o.row) {
            return -1;
        } else {
            if (this.proximity > o.proximity) {
                return 1;
            } else if (this.proximity < o.proximity) {
                return -1;
            } else {
                if (this.arrivalNum > o.arrivalNum) {
                    return 1;
                } else if (this.arrivalNum < o.arrivalNum) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }
    }
}
