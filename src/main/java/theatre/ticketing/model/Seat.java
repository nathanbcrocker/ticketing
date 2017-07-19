package theatre.ticketing.model;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Seat implements ISeat {

    private static char ROW_OFFSET = 'A';
    private static int COLUMN_OFFSET = 1;

    public Seat() {
        this(0,0);
    }

    public Seat(int row, int column) {
        this.setRow(row);
        this.setColumn(column);
    }

    public Seat(String seatNumber) {
        this.setSeatNumber(seatNumber);
    }

    public void setSeatNumber(String seatNumber) {
        if (seatNumber == null) {
            return;
        }

        Pattern letter = Pattern.compile("[a-zA-Z]+");
        Pattern number = Pattern.compile("[0-9+]");
        Matcher letterMatcher = letter.matcher(seatNumber);
        Matcher numberMatcher = number.matcher(seatNumber);

        if (letterMatcher.find()) {
            this.setRow(letterMatcher.group().charAt(0) - ROW_OFFSET);
        }

        if (numberMatcher.find()) {
            this.setColumn(Integer.parseInt(numberMatcher.group().toString()) - COLUMN_OFFSET);
        }

        this.seatNumber = seatNumber;
    }

    @Override
    public void setStatus(SeatStatus status) {
        this.status = status;
    }

    @Override
    public SeatStatus getStatus() {
        return  this.status;
    }

    /*
    public Seat() {
        this(null);
    }



    @Override
    public void setSeatNumber(String seatNumber) {
        if (seatNumber == null) {
            return;
        }

        this.seatNumber = seatNumber;
    }*/

    @Override
    public String getSeatNumber() {
        return String.format("%s%d", (char)(this.getRow() + 65), this.getColumn() + 1);
    }

    @Override
    public int getRow() {
        return this.row;
    }

    @Override
    public void setRow(int row) {
        this.row = row;
    }

    @Override
    public int getColumn() {
        return this.column;
    }

    @Override
    public void setColumn(int column) {
        this.column = column;
    }

    @Override
    public boolean isAvailable() {
        return this.status == SeatStatus.Available;
    }

    @Override
    public int compareTo(ISeat seat) {
        if (this.getColumn() < seat.getColumn())
            return -1;

        if (this.getColumn() > seat.getColumn())
            return 1;

        return 0;
    }

    private void parseSeatNumber(String seatString) {

    }

    private String seatNumber;
    private int row;
    private int column;
    private SeatStatus status = SeatStatus.Available;
}
