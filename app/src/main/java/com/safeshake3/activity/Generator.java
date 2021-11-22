package com.safeshake3.activity;

import com.safeshake3.R;

public class Generator extends ParentActivity {
    final int MENU_ID = R.id.generator;
    final int LAYOUT_ID = R.layout.activity_generator;

    @Override
    protected int getResourceLayoutId() {
        return LAYOUT_ID;
    }

    @Override
    protected int getResourceMenuId() {
        return MENU_ID;
    }

}