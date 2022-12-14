package com.kismiwati.application.fragments.update

import android.app.AlertDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.kismiwati.application.R
import com.kismiwati.application.model.User
import com.kismiwati.application.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*
import kotlinx.android.synthetic.main.fragment_update.view.update_firstname_et

class UpdateFragment : Fragment() {

    private val args by navArgs<UpdateFragmentArgs>()

    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // digunakan untuk mengembangkan fragment
        val view = inflater.inflate(R.layout.fragment_update, container, false)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        view.update_firstname_et.setText(args.currentUser.firstName)
        view.update_lastname_et.setText(args.currentUser.lastName)
        //untuk mengkonfersikan string karena jumlah adalah bilangan bulat
        view.update_age_et.setText(args.currentUser.age.toString())
        view.update_btn.setOnClickListener {
            updateItem()
        }

        // digunakan untuk menambahakan menu hapus
        setHasOptionsMenu(true)

        return view
    }

    //digunakan untuk mengubah atau mengedit data
    private fun updateItem() {
        val firstName = update_firstname_et.text.toString()
        val lastName = update_lastname_et.text.toString()
        val age = Integer.parseInt(update_age_et.text.toString())

        if (inputCheck(firstName, lastName, update_age_et.text)) {
            val updateUser = User(args.currentUser.id, firstName, lastName, age)

            mUserViewModel.updateUser(updateUser)

            Toast.makeText(requireContext(), "Successfully updated!", Toast.LENGTH_SHORT).show()

            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        } else {
            Toast.makeText(requireContext(), "Please fill out all fields!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(firstName: String, lastName: String, age: Editable): Boolean {
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && age.isEmpty())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_delete) {
            deleteUser()
        }
        return super.onOptionsItemSelected(item)
    }

    //digunakan untuk menghapus data
    private fun deleteUser() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") {_, _ ->
            mUserViewModel.deleteUser(args.currentUser)
            Toast.makeText(
                requireContext(),
                "Successfully removed: ${args.currentUser.firstName}",
                Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }
        builder.setNegativeButton("No") {_, _ ->}
        builder.setTitle("Delete ${args.currentUser.firstName}?")
        builder.setMessage("Are you sure want to delete ${args.currentUser.firstName}?")
        builder.create().show()
    }
}