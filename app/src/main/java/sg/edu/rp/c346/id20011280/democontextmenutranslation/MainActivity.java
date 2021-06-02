package sg.edu.rp.c346.id20011280.democontextmenutranslation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvTranslatedText;
    TextView tvTranslatedText2;

    String wordClicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTranslatedText = findViewById(R.id.textViewTranslatedText);
        tvTranslatedText2 = findViewById(R.id.textViewTranslatedText2);

        registerForContextMenu(tvTranslatedText); // allows us to receive the long press
        registerForContextMenu(tvTranslatedText2);


    }
    @Override // in parent class
    public void onCreateContextMenu(ContextMenu menu, View v, // what started the context menu
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo); // mandatory

        menu.add(0,0,0,"English"); // adding items into the menu
        menu.add(0,1,1,"Italian"); // adding items into the menu

        if(v == tvTranslatedText)
        {
            wordClicked = "Hello";
        }
        else if(v == tvTranslatedText2)
        {
            wordClicked = "Bye";
        }
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getItemId()==0) { //check whether the selected menu item ID is 0
            //code for action
            Toast.makeText(MainActivity.this, "English is chosen", Toast.LENGTH_SHORT).show();

            if(wordClicked.equalsIgnoreCase("Hello"))
            {
                tvTranslatedText.setText("Hello");
            }
            else if(wordClicked.equalsIgnoreCase("Bye"))
            {
                tvTranslatedText2.setText("Bye");
            }
            return true; //menu item successfully handled
        }
        else if(item.getItemId()==1) { //check if the selected menu item ID is 1
            //code for action
            Toast.makeText(MainActivity.this,"Italian is chosen", Toast.LENGTH_SHORT).show();

            if(wordClicked.equalsIgnoreCase("Hello"))
            {
                tvTranslatedText.setText("Ciao");// set the new text to the chosen language
            }
            else if(wordClicked.equalsIgnoreCase("Bye"))
            {
                tvTranslatedText2.setText("Adios");
            }


            return true;  //menu item successfully handled
        }

        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }



}