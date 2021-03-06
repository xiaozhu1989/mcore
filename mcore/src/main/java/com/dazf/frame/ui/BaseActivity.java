package com.dazf.frame.ui;

import android.widget.Toast;

import com.dazf.frame.base.BasePresenter;
import com.dazf.frame.base.RxBaseActivity;
import com.dazf.frame.widget.dialog.ProgressView;

/**
 * @author ZhuZiBo
 * @date 2018/1/15
 */
public abstract class BaseActivity<P extends BasePresenter> extends RxBaseActivity<P> {

    private ProgressView progressView;

    @Override
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading(String message) {
        progressView = ProgressView.showMessage(this, message);
    }

    @Override
    public void dismissLoading() {
        if (progressView != null) {
            progressView.dismiss();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (progressView != null) {
            progressView.dismiss();
            progressView = null;
        }
    }
}
