package cbq.android.project_note_book;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cbq.android.project_note_book.adapter.MyFragmentPagerAdapter;
import cbq.android.project_note_book.fragment.AboutMeFragment;
import cbq.android.project_note_book.fragment.InAbeyanceFragment;
import cbq.android.project_note_book.fragment.NoteFragment;

/**
 * 启动
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    /**
     * ViewPager2
     */
    ViewPager2 viewPager;
    /**
     * 顶部 笔记 标签
     */
    TextView note;
    /**
     * 顶部 待办 标签
     */
    TextView in_abeyance;
    /**
     * 顶部 关于我 标签
     */
    TextView about_me;
    /**
     * 回收站按钮
     */
    ImageView recycle_bin;
    /**
     * 标志当前显示笔记页面或者待办页面
     * 0 为笔记 | 1 为待办
     */
    public static int status = 0;

    // 初始化
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        super.onCreate(savedInstanceState);

        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getResources().getColor(R.color.light_grey));
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        setContentView(R.layout.activity_main);

        note = findViewById(R.id.note);
        note.setOnClickListener(this);
        in_abeyance = findViewById(R.id.in_abeyance);
        in_abeyance.setOnClickListener(this);
        about_me = findViewById(R.id.about_me);

        initViewPager();
    }

    @Override
    protected void onResume() {
        super.onResume();

        viewPager.setCurrentItem(status);
    }

    @Override
    protected void onPause() {
        super.onPause();

        status = viewPager.getCurrentItem();
    }

    /**
     * 初始化 ViewPager2
     */
    private void initViewPager() {
        viewPager = findViewById(R.id.mainViewPager2);

        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(NoteFragment.newInstance());
        fragmentList.add(InAbeyanceFragment.newInstance());
        fragmentList.add(AboutMeFragment.newInstance());

        MyFragmentPagerAdapter myFragmentPagerAdapter =
                new MyFragmentPagerAdapter(getSupportFragmentManager(),
                        getLifecycle(), fragmentList);

        viewPager.setAdapter(myFragmentPagerAdapter);
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                changeFragment(position);
            }
        });
    }

    /**
     * 切换 Fragment
     *
     * @param position position
     */
    @SuppressLint("NonConstantResourceId")
    private void changeFragment(int position) {
        if (position == R.id.note) {
            viewPager.setCurrentItem(0);
        } else if (position == R.id.in_abeyance) {
            viewPager.setCurrentItem(1);
        } else if (position == R.id.about_me) {
            viewPager.setCurrentItem(2);
        } else {
            selected(position);
        }
    }

    /**
     * 选中标签
     * @param position position
     */
    private void selected(int position) {
        switch (position) {
            case 0:
                note.setTextColor(note.getResources().getColor(R.color.black));
                in_abeyance.setTextColor(in_abeyance.getResources().getColor(R.color.dark_grey));
                about_me.setTextColor(about_me.getResources().getColor(R.color.dark_grey));
                break;
            case 1:
                in_abeyance.setTextColor(in_abeyance.getResources().getColor(R.color.black));
                note.setTextColor(note.getResources().getColor(R.color.dark_grey));
                about_me.setTextColor(about_me.getResources().getColor(R.color.dark_grey));
                break;
            case 2:
                about_me.setTextColor(about_me.getResources().getColor(R.color.black));
                note.setTextColor(note.getResources().getColor(R.color.dark_grey));
                in_abeyance.setTextColor(in_abeyance.getResources().getColor(R.color.dark_grey));
                break;
            default:
                Log.d("MainActivity", "selected: " + position);
                break;
        }
    }

    /**
     * onClick
     *
     * @param view The view that was clicked.
     */
    @Override
    public void onClick(View view) {
        changeFragment(view.getId());
    }
}