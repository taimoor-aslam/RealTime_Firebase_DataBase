package com.example.realtimefirebasedatabase;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.solver.widgets.Snapshot;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MyFragment extends Fragment {
    EditText email,passcode;
    TextView signup,txt;
    Button login_btn;
    View view;
    List<MyListData> userData=new ArrayList<MyListData>();
    DatabaseReference mReferences; //to access database
   // SqlDataBase db;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.activity_my_fragment,container,false);
        email=(EditText) view.findViewById(R.id.emaailedt);
        passcode=(EditText) view.findViewById(R.id.passcodeedt);
        signup=(TextView) view.findViewById(R.id.singuptxt);
        login_btn=(Button) view.findViewById(R.id.loginbtn);
        txt=(TextView) view.findViewById(R.id.showttxt1);
       // db=new SqlDataBase(getContext());
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new SignUpFragment());
            }
        });


        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try
                {
                    String Email=email.getText().toString();
                    String pass=passcode.getText().toString();
                    if(verify(Email,pass))
                    {
                      //  loadFragment(new UserDataFragment());
                    }
                    else {
                           email.setError("wrong email");
                           passcode.setError("wrong password");
                    }

//                    if(db.verify(Email,pass))
//                    {
//                        Toast.makeText(getActivity(),"Login Successfull",Toast.LENGTH_SHORT).show();
//                        loadFragment(new UserDataFragment());
//                        //  txt.setText(db.show());
//                    }
//                    else
//                    {
//                        email.setError("wrong email");
//                        passcode.setError("wrong password");
//                    }


                }
                catch (Exception e)
                {
                    Toast.makeText(getActivity(),e.toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }
    public void loadFragment(Fragment fragment)
    {
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framelayout,fragment);
        fragmentTransaction.commit();
    }

    public boolean verify(String email,String passcode)
    {

        mReferences=FirebaseDatabase.getInstance().getReference("user");

        try {
            mReferences.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    Toast.makeText(getContext(), "hello", Toast.LENGTH_LONG).show();
                    for (DataSnapshot data : snapshot.getChildren()) {
                        MyListData myListData=data.getValue(MyListData.class);
                        userData.add(myListData);
                    }
//                    MyListData myListData=snapshot.getValue(MyListData.class);
//                    userData.add(myListData);

                    Toast.makeText(getContext(),String.valueOf(userData.size()) , Toast.LENGTH_LONG).show();
                    Log.d("val",String.valueOf(userData.size()));
                }


                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(getContext(), "Sorry! Data couldn't be Read from database", Toast.LENGTH_LONG).show();
                }
            });
        }
        catch (Exception e)
        {
            Toast.makeText(getContext(),e.toString(),Toast.LENGTH_SHORT).show();
        }
         //  Toast.makeText(getContext(),userData.size(),Toast.LENGTH_SHORT).show();
           for(int i=0;i<userData.size();i++)
           {
               if(email.equals(userData.get(i).getmEmail())&&passcode.equals(userData.get(i).getmPasscode()))
               {
                   return true;
               }
           }
           return false;

    }
}

