package com.alfianyusufabdullah;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonesrandom on 12/19/17.
 * <p>
 * AA
 */

public class SPager extends ViewPager {

    List<PageModel> pages = new ArrayList<>();
    FragmentManager manager;
    TabLayout tab;

    public SPager(@NonNull Context context) {
        super(context);
    }

    public SPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void initFragmentManager(FragmentManager manager) {
        this.manager = manager;
    }

    public void addTabLayout(TabLayout tab) {
        this.tab = tab;
    }

    public void addPages(String Title, Fragment Page) {
        pages.add(new PageModel(Page, Title));
    }

    public void build() {
        if (manager == null) {
            throw new RuntimeException("Add initFragmentManager() before you call build()");
        }

        if (tab != null) {
            tab.setupWithViewPager(this);
        }
        PageAdapter adapter = new PageAdapter(manager);
        adapter.setPages(pages);
        setAdapter(adapter);
    }
}
