package pe.edu.ulima.pruebacalificada3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
/**
 * Created by sodm on 6/23/2017.
 */

public class NavigationActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private boolean mDrawerOpened = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_menu);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                item.setChecked(true);
                if (item.getItemId() == R.id.equipos){
                    FragmentManager fMan = getSupportFragmentManager();
                    FragmentTransaction ft = fMan.beginTransaction();
                    ft.replace(R.id.flaContenido,new Fragment_Equipos());
                    ft.addToBackStack(null);
                    ft.commit();
                }else if (item.getItemId() == R.id.tablaPosiciones){
                    FragmentManager fMan = getSupportFragmentManager();
                    FragmentTransaction ft = fMan.beginTransaction();
                    ft.replace(R.id.flaContenido,new Fragment_Posiciones());
                    ft.addToBackStack(null);
                    ft.commit();
                }
                drawerLayout.closeDrawers();
                return true;
            }
        });

        FragmentManager fMan = getSupportFragmentManager();
        FragmentTransaction ft = fMan.beginTransaction();
        ft.add(R.id.flaContenido,new Fragment_Equipos());
        ft.addToBackStack(null);
        ft.commit();


}

}