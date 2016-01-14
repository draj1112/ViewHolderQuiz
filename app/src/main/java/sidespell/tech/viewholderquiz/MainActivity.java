package sidespell.tech.viewholderquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import sidespell.tech.viewholderquiz.fragments.GridViewFragment;
import sidespell.tech.viewholderquiz.fragments.ListViewFragment;

public class MainActivity extends AppCompatActivity {

    private ListViewFragment mListViewFragment;
    private GridViewFragment mGridViewFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Create new instances of the fragment
        mListViewFragment = ListViewFragment.newInstance();
        mGridViewFragment = GridViewFragment.newInstance();

        // Set the main content view to the listview fragment
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, mListViewFragment)
                .commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_listview) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainer, mListViewFragment)
                    .commit();
            return true;
        } else if (id == R.id.action_gridview) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainer, mGridViewFragment)
                    .commit();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
