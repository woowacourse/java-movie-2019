package domain;

class ResevationRecord {

    private int reserveMovieId;
    private int reserveMovieCapacity;
    private int reserveMovieEntryNumber;

    ResevationRecord(int reserveMovieId, int reserveMovieCapacity, int reserveMovieEntryNumber) {
        this.reserveMovieId = reserveMovieId;
        this.reserveMovieCapacity = reserveMovieCapacity;
        this.reserveMovieEntryNumber = reserveMovieEntryNumber;
    }
}

