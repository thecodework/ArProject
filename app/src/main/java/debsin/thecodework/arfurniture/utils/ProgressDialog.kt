package debsin.thecodework.arfurniture.utils

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import debsin.thecodework.arfurniture.R

class ProgressDialog: Dialog {

    private var mContext: Context? = null

    constructor(context: Context) : super(context) {
        this.mContext = context
    }
    constructor(context: Context, theme: Int) : super(context, theme)


    fun showProgressDialog(){
        try {
            if (pDialog == null){
                inflateProgressDialog()
                pDialog!!.setCanceledOnTouchOutside(false)
                pDialog!!.show()
            }
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

    fun hideProgressDialog(){
        try {
            if (pDialog != null){
                if (pDialog!!.isShowing)
                    pDialog!!.dismiss()
                pDialog = null
            }
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

    @SuppressLint("InflateParams")
    private fun inflateProgressDialog(): ProgressDialog {
        val inflator = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflator.inflate(R.layout.progress_dialog, null)
        pDialog = ProgressDialog(context, R.style.custom_progress)
        (pDialog as ProgressDialog).setContentView(view)
        return pDialog as ProgressDialog
    }

    companion object {
        private var pDialog: Dialog? = null
    }

}