package com.max.practica5;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.style.AlignmentSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CheckBox boldCheckBox = findViewById(R.id.cbNegrita);
        CheckBox underlineCheckBox = findViewById(R.id.cbSubrayado);
        CheckBox italicCheckBox = findViewById(R.id.cbCursiva);
        CheckBox centerCheckBox = findViewById(R.id.cbCentrado);
        EditText rtxtEditor = findViewById(R.id.rtxtEditor);
        rtxtEditor.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE | InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS | InputType.TYPE_TEXT_FLAG_IME_MULTI_LINE);
        SpannableStringBuilder builder = new SpannableStringBuilder(rtxtEditor.getText());
        rtxtEditor.setText(builder);

        // TextWatcher
        rtxtEditor.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(boldCheckBox.isChecked())
                    builder.setSpan(new StyleSpan(Typeface.BOLD), i, i + i2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                if(underlineCheckBox.isChecked())
                    builder.setSpan(new UnderlineSpan(), i, i + i2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                if(italicCheckBox.isChecked())
                    builder.setSpan(new StyleSpan(Typeface.ITALIC), i, i + i2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                if(centerCheckBox.isChecked())
                    builder.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER), i, i + i2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
            @Override
            public void afterTextChanged(Editable editable) {}
        });

        boldCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    int startSelection = rtxtEditor.getSelectionStart();
                    int endSelection = rtxtEditor.getSelectionEnd();
                    builder.setSpan(new StyleSpan(Typeface.BOLD), startSelection, endSelection, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                } else {
                    // Eliminar la negrita del texto actual en el cursor si el CheckBox no está marcado
                    StyleSpan[] spans = builder.getSpans(rtxtEditor.getSelectionStart(), rtxtEditor.getSelectionEnd(), StyleSpan.class);
                    for (StyleSpan span : spans) {
                        if (span.getStyle() == Typeface.BOLD) {
                            builder.removeSpan(span);
                        }
                    }
                }
                rtxtEditor.setText(builder);
            }
        });

        underlineCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
// Aplicar subrayado al texto actual en el cursor si el CheckBox está marcado
                    int startSelection = rtxtEditor.getSelectionStart();
                    int endSelection = rtxtEditor.getSelectionEnd();
                    builder.setSpan(new UnderlineSpan(), startSelection, endSelection, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                } else {
// Eliminar el subrayado del texto actual en el cursor si el CheckBox no está marcado
                    UnderlineSpan[] spans = builder.getSpans(rtxtEditor.getSelectionStart(), rtxtEditor.getSelectionEnd(), UnderlineSpan.class);
                    for (UnderlineSpan span : spans) {
                        builder.removeSpan(span);
                    }
                }
                rtxtEditor.setText(builder);
            }
        });

        italicCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    // Aplicar cursiva al texto actual en el cursor si el CheckBox está marcado
                    int startSelection = rtxtEditor.getSelectionStart();
                    int endSelection = rtxtEditor.getSelectionEnd();
                    builder.setSpan(new StyleSpan(Typeface.ITALIC), startSelection, endSelection, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                } else {
                    // Eliminar la cursiva del texto actual en el cursor si el CheckBox no está marcado
                    StyleSpan[] spans = builder.getSpans(rtxtEditor.getSelectionStart(), rtxtEditor.getSelectionEnd(), StyleSpan.class);
                    for (StyleSpan span : spans) {
                        if (span.getStyle() == Typeface.ITALIC) {
                            builder.removeSpan(span);
                        }
                    }
                }
                rtxtEditor.setText(builder);
            }
        });
        centerCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    // Centrar el texto actual en el cursor si el CheckBox está marcado
                    int startSelection = rtxtEditor.getSelectionStart();
                    int endSelection = rtxtEditor.getSelectionEnd();
                    builder.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER), startSelection, endSelection, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                } else {
                    // Eliminar el centrado del texto actual en el cursor si el CheckBox no está marcado
                    AlignmentSpan[] spans = builder.getSpans(rtxtEditor.getSelectionStart(), rtxtEditor.getSelectionEnd(), AlignmentSpan.class);
                    for (AlignmentSpan span : spans) {
                        if (span.getAlignment() == Layout.Alignment.ALIGN_CENTER) {
                            builder.removeSpan(span);
                        }
                    }
                }
                rtxtEditor.setText(builder);
            }
        });



    }
}