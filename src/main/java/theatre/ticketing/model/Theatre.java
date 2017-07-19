package theatre.ticketing.model;

import java.util.*;

public class Theatre {

    public void addRow(IRow row) throws RowException {
        if (row == null) {
            return;
        }

        if (seating.contains(row) || seating.size() > row.getRowNumber()) {
            throw new RowException();
        }

        seating.add(row);
    }

    public IRow getRow(int rowNumber) {
        if (rowNumber > seating.size()) {
            return new NullRow();
        }

        return seating.get(rowNumber);
    }

    public int getRowCount() {
        return seating.size();
    }

    private List<IRow> seating = new ArrayList<>();
}
