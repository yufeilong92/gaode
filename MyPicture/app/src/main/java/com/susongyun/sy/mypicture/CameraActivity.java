package com.susongyun.sy.mypicture;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import me.iwf.photopicker.PhotoPicker;
import me.iwf.photopicker.PhotoPreview;

/**
 * @Author : Yufeilong  is Creating a porject in YFPHILPS
 * @Email : yufeilong92@163.com
 * @Time :2016/12/5 10:09
 * @Purpose :照相
 */
public class CameraActivity extends AppCompatActivity implements View.OnClickListener {
    private Button play_Camera;
    private PhotoAdapter photoAdapter;
    private ArrayList<String> selectedPhotos = new ArrayList<>();
    private RecyclerView recycler_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera_activity);
        initView();
        initContent();
    }

    private void initContent() {

        photoAdapter = new PhotoAdapter(CameraActivity.this, selectedPhotos);
        recycler_view.setLayoutManager(new StaggeredGridLayoutManager(4, OrientationHelper.VERTICAL));
        recycler_view.setAdapter(photoAdapter);

        recycler_view.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        PhotoPreview.builder()
                                .setPhotos(selectedPhotos)
                                .setCurrentItem(position)
                                .start(CameraActivity.this);
                    }
                })
        );

    }

    private void initView() {
        play_Camera = (Button) findViewById(R.id.play_Camera);
        play_Camera.setOnClickListener(this);
        recycler_view = (RecyclerView) findViewById(R.id.recycler_view);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.play_Camera:
                PhotoPicker.builder()
                        .setPhotoCount(9)
                        .setGridColumnCount(4)
                        .start(this);
                break;
            default:
                break;
        }
    }

    @Override
    public boolean shouldShowRequestPermissionRationale(String permission) {
        return false;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && (requestCode == PhotoPicker.REQUEST_CODE || requestCode ==
                PhotoPreview.REQUEST_CODE)) {
            List<String> photos = null;
            if (data != null) {
                photos = data.getStringArrayListExtra(PhotoPicker.KEY_SELECTED_PHOTOS);
            }
            selectedPhotos.clear();
            if (photos != null) {
                selectedPhotos.addAll(photos);
            }
            photoAdapter.notifyDataSetChanged();

        }
    }

    }

