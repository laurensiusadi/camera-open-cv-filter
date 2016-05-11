package me.pankiewicz.will.cameratia;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class LabActivity extends AppCompatActivity {

    public static final String PHOTO_FILE_EXTENSION = ".png";
    public static final String PHOTO_MIME_TYPE = "image/png";

    public static final String EXTRA_PHOTO_URI = "me.pankiewicz.will.cameratia.LabActivity.extra.PHOTO_URI";
    public static final String EXTRA_PHOTO_DATA_PATH = "me.pankiewicz.will.cameratia.LabActivity.extra.PHOTO_DATA_PATH";

    private Uri mUri;
    private String mDataPath;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Intent intent = getIntent();
        mUri = intent.getParcelableExtra(EXTRA_PHOTO_URI);
        mDataPath = intent.getStringExtra(EXTRA_PHOTO_DATA_PATH);

        setContentView(R.layout.activity_lab);

        final ImageView imageView;
        imageView = (ImageView) findViewById(R.id.photo_preview);
        if (imageView != null) {
            imageView.setImageURI(mUri);
        }
        //setContentView(imageView);

        final ImageView imageViewShare = (ImageView) findViewById(R.id.share);
        if (imageViewShare != null) {
            imageViewShare.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sharePhoto();
                }
            });
        }
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        getMenuInflater().inflate(R.menu.activity_lab, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_delete:
                deletePhoto();
                return true;
            case R.id.menu_edit:
                editPhoto();
                return true;
            case R.id.menu_share:
                sharePhoto();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    // Show a confirmation dialog. On confirmation, the photo is deleted and teh activity finishes
    private void deletePhoto() {
        final AlertDialog.Builder alert = new AlertDialog.Builder(LabActivity.this);
        alert.setTitle(R.string.photo_delete_prompt_title);
        alert.setMessage(R.string.photo_delete_prompt_message);
        alert.setCancelable(false);
        alert.setPositiveButton(R.string.delete, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(final DialogInterface dialog, final int which) {
                getContentResolver().delete(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, MediaStore.MediaColumns.DATA + "=?", new String[]{mDataPath});
                finish();
            }
        });
        alert.setNegativeButton(android.R.string.cancel, null);
        alert.show();
    }

    // Show a chooser so that the user may pick an app for editing the photo
    private void editPhoto() {
        final Intent intent = new Intent(Intent.ACTION_EDIT);
        intent.setDataAndType(mUri, PHOTO_MIME_TYPE);
        startActivity(Intent.createChooser(intent, getString(R.string.photo_edit_chooser_title)));
    }

    // Show a chooser so that the user may pick an app for sending the photo
    private void sharePhoto() {
        final Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType(PHOTO_MIME_TYPE);
        intent.putExtra(Intent.EXTRA_STREAM, mUri);
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.photo_send_extra_subject));
        intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.photo_send_extra_text));
        startActivity(Intent.createChooser(intent, getString(R.string.photo_send_chooser_title)));
    }
}
