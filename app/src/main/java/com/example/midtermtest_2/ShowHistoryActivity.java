package com.example.midtermtest_2;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import com.example.midtermtest_2.R;

public class ShowHistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_history);

        ArrayList<History> historyList = ((Myapp) getApplication()).historyList;

        ArrayList<String> historyStrings = new ArrayList<>();
        for (History history : historyList) {
            // Customize this based on your History class structure
            String historyString = history.getType() + " - " +
                    history.getTotal() + " - " +
                    history.getQuantity() + " - " +
                    history.getDate().toString();
            historyStrings.add(historyString);
        }

        ListView historyListView = findViewById(R.id.historyListView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                historyStrings
        );

        historyListView.setAdapter(adapter);
    }
}
