package net.flow9.thisiskotlin.applemarket

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class MyDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            // Use the Builder class for convenient dialog construction
            val builder = AlertDialog.Builder(it)
            builder.setTitle("종료")
            builder.setMessage("사과마켓을 종료하시겠습니까?")
                .setPositiveButton("넹") { dialog, id ->
                    // Send the positive button event back to the host activity
                    activity?.finish()
                    //액티비티를 종료
                }
                .setNegativeButton("아녀") { dialog, id ->
                    // Send the negative button event back to the host activity
                    //아무것도 안함 = 다이얼로그 종료
                }
            // Create the AlertDialog object and return it
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}
