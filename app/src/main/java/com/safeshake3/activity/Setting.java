package com.safeshake3.activity;

import com.safeshake3.R;

public class Setting extends ParentActivity {
    final int MENU_ID = R.id.setting;
    final int LAYOUT_ID = R.layout.activity_setting;

    @Override
    protected int getResourceLayoutId() {
        return LAYOUT_ID;
    }

    @Override
    protected int getResourceMenuId() {
        return MENU_ID;
    }
}