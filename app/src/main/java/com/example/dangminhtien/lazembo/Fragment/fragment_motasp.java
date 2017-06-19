package com.example.dangminhtien.lazembo.Fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.example.dangminhtien.lazembo.R;
import com.larswerkman.holocolorpicker.ColorPicker;
import com.larswerkman.holocolorpicker.OpacityBar;
import com.larswerkman.holocolorpicker.SVBar;
import com.larswerkman.holocolorpicker.SaturationBar;
import com.larswerkman.holocolorpicker.ValueBar;

import java.util.ArrayList;

import jp.wasabeef.richeditor.RichEditor;

public class fragment_motasp extends Fragment implements fragment_product.trasnfer_motasp {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    static int text_size = 3;
    // Phải để là static để tránh lỗi null pointer exception
    private static RichEditor txt_motachitiet;
    private final ArrayList<Integer> size = new ArrayList<Integer>(7);
    private ImageButton btn_align_left, btn_align_right, btn_align_center, btn_bold,
            btn_italic, btn_underline, btn_text_color, btn_text_size_decrease,
            btn_text_size_increase, btn_confirm;
    private Spinner sp_text_size;
    private ColorPicker picker;
    private SVBar svBar;
    private OpacityBar opacityBar;
    private SaturationBar saturationBar;
    private ValueBar valueBar;
    private AlertDialog dialog_choose_picker;

    public fragment_motasp() {
        // Required empty public constructor
    }


    public static fragment_motasp newInstance(String param1, String param2) {
        fragment_motasp fragment = new fragment_motasp();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_motasp, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addControls(view);
        addEvents();
    }

    private void addControls(View view) {
        txt_motachitiet = (RichEditor) view.findViewById(R.id.txt_motachitiet);
        btn_align_center = (ImageButton) view.findViewById(R.id.btn_align_Center);
        btn_align_left = (ImageButton) view.findViewById(R.id.btn_align_Left);
        btn_align_right = (ImageButton) view.findViewById(R.id.btn_align_Right);
        btn_bold = (ImageButton) view.findViewById(R.id.btn_bold);
        btn_italic = (ImageButton) view.findViewById(R.id.btn_italic);
        btn_underline = (ImageButton) view.findViewById(R.id.btn_underline);
        btn_text_color = (ImageButton) view.findViewById(R.id.btn_text_color);
        btn_text_size_decrease = (ImageButton) view.findViewById(R.id.btn_text_size_decrease);
        btn_text_size_increase = (ImageButton) view.findViewById(R.id.btn_text_size_increase);
        sp_text_size = (Spinner) view.findViewById(R.id.sp_text_size);
        createDialog();
        addSize();
        sp_text_size.setAdapter(new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, size));
        txt_motachitiet.setPlaceholder("Nhập nội dung vào đây");
    }

    private void createDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_choose_color, null);
        picker = (ColorPicker) view.findViewById(R.id.picker);
        svBar = (SVBar) view.findViewById(R.id.svbar);
        valueBar = (ValueBar) view.findViewById(R.id.valuebar);
        saturationBar = (SaturationBar) view.findViewById(R.id.saturationbar);
        opacityBar = (OpacityBar) view.findViewById(R.id.opacitybar);
        picker.addOpacityBar(opacityBar);
        picker.addSaturationBar(saturationBar);
        picker.addValueBar(valueBar);
        picker.addSVBar(svBar);
        builder.setView(view);
        dialog_choose_picker = builder.create();
        dialog_choose_picker.setCanceledOnTouchOutside(true);
        btn_confirm = (ImageButton) view.findViewById(R.id.btn_confirm);

    }

    private void addSize() {
        size.add(1);
        size.add(2);
        size.add(3);
        size.add(4);
        size.add(5);
        size.add(6);
        size.add(7);
    }

    private void addEvents() {

        btn_underline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_motachitiet.setUnderline();
            }
        });

        btn_italic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_motachitiet.setItalic();
            }
        });

        btn_bold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_motachitiet.setBold();
            }
        });

        btn_align_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_motachitiet.setAlignRight();
            }
        });

        btn_align_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_motachitiet.setAlignLeft();
            }
        });

        btn_align_center.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_motachitiet.setAlignCenter();
            }
        });

        btn_text_size_decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_size -= 1;
                txt_motachitiet.setFontSize(text_size);
            }
        });

        btn_text_size_increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_size += 1;
                txt_motachitiet.setFontSize(text_size);

            }
        });

        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_motachitiet.setTextColor(picker.getColor());
                dialog_choose_picker.dismiss();
            }
        });

        btn_text_color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog_choose_picker.show();
            }
        });

        dialog_choose_picker.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                String hexColor = String.format("%06X", (0xFFFFFF & picker.getColor()));
                txt_motachitiet.setTextColor(Integer.parseInt(hexColor, 16));
            }
        });

        sp_text_size.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                txt_motachitiet.setFontSize(position + 1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    @Override
    public String transfer_text() {
        return txt_motachitiet.getHtml();

    }
}
