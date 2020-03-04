package com.bomnie.jollypic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.Image;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.ml.vision.FirebaseVision;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import com.google.firebase.ml.vision.common.FirebaseVisionPoint;
import com.google.firebase.ml.vision.face.FirebaseVisionFace;
import com.google.firebase.ml.vision.face.FirebaseVisionFaceContour;
import com.google.firebase.ml.vision.face.FirebaseVisionFaceDetector;
import com.google.firebase.ml.vision.face.FirebaseVisionFaceDetectorOptions;
import com.google.firebase.ml.vision.face.FirebaseVisionFaceLandmark;

import java.util.List;

public class FaceActivity extends AppCompatActivity {

   Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_face);
        mContext= this;

        final RelativeLayout relative = findViewById(R.id.relative);

        FirebaseVisionFaceDetectorOptions options =
                new FirebaseVisionFaceDetectorOptions.Builder()
                        .setPerformanceMode(FirebaseVisionFaceDetectorOptions.ACCURATE)
                        .setLandmarkMode(FirebaseVisionFaceDetectorOptions.ALL_LANDMARKS)
                        .setClassificationMode(FirebaseVisionFaceDetectorOptions.ALL_CLASSIFICATIONS)
                        .build();

        final Bitmap bitmap = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.gimin);


        final FirebaseVisionImage image = FirebaseVisionImage.fromBitmap(bitmap);


        FirebaseVisionFaceDetector detector = FirebaseVision.getInstance()
                .getVisionFaceDetector(options);

        Task<List<FirebaseVisionFace>> result =
                detector.detectInImage(image)
                        .addOnSuccessListener(
                                new OnSuccessListener<List<FirebaseVisionFace>>() {
                                    @Override
                                    public void onSuccess(List<FirebaseVisionFace> faces) {
                                        // Task completed successfully

                                        Point p = new Point();
                                        Display display  = getWindowManager().getDefaultDisplay();
                                        display.getSize(p);


                                        for (FirebaseVisionFace face : faces) {
                                            // 얼굴이 여러 개인 경우를 대비해서 for문

                                            // If landmark detection was enabled (mouth, ears, eyes, cheeks, and
                                            // nose available):
                                            FirebaseVisionFaceLandmark leftEye = face.getLandmark(FirebaseVisionFaceLandmark.LEFT_EYE);
                                            float lex = leftEye.getPosition().getX();
                                            float ley = leftEye.getPosition().getY();

                                            FirebaseVisionFaceLandmark leftCheek = face.getLandmark(FirebaseVisionFaceLandmark.LEFT_CHEEK);
                                            float lcx = leftCheek.getPosition().getX();
                                            float lcy = leftCheek.getPosition().getY();

                                            FirebaseVisionFaceLandmark rightCheek = face.getLandmark(FirebaseVisionFaceLandmark.RIGHT_CHEEK);
                                            float rcx = rightCheek.getPosition().getX();
                                            float rcy = rightCheek.getPosition().getY();

                                            // 이미지 뷰를 가상으로 만들기
                                            ImageView image_leftEye= new ImageView(mContext);
                                            image_leftEye.setImageResource(R.drawable.mung);
                                            image_leftEye.setX(p.x * lex / bitmap.getWidth() - 100);
                                            image_leftEye.setY(p.y * ley / bitmap.getHeight() - 100);
                                            // 사이즈의 절반을 빼줘서 눈의 중간으로 올라가도록

                                            // relative layout 위에 올릴 사진 크기 조절
                                            image_leftEye.setLayoutParams(new RelativeLayout.LayoutParams(200,200));

                                            relative.addView(image_leftEye);

                                            ImageView image_leftCheek= new ImageView(mContext);
                                            image_leftCheek.setImageResource(R.drawable.left_whiskers);
                                            image_leftCheek.setX(p.x * lcx / bitmap.getWidth() - 100);
                                            image_leftCheek.setY((p.y * lcy / bitmap.getHeight() - 100));
                                            image_leftCheek.setLayoutParams(new RelativeLayout.LayoutParams(200,200));

                                            relative.addView(image_leftCheek);

                                            ImageView image_rightCheek= new ImageView(mContext);
                                            image_rightCheek.setImageResource(R.drawable.right_whiskers);
                                            image_rightCheek.setX(p.x * rcx / bitmap.getWidth() - 100);
                                            image_rightCheek.setY((p.y * rcy / bitmap.getHeight() - 100));
                                            image_rightCheek.setLayoutParams(new RelativeLayout.LayoutParams(200,200));

                                            relative.addView(image_rightCheek);

                                        }
                                    }
                                })
                        .addOnFailureListener(
                                new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        // Task failed with an exception
                                        // ...
                                    }
                                });
    }
}
