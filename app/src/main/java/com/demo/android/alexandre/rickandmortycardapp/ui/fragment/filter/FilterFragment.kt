package com.demo.android.alexandre.rickandmortycardapp.ui.fragment.filter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.demo.android.alexandre.rickandmortycardapp.R
import com.demo.android.alexandre.rickandmortycardapp.extensions.getTextButtonChecked
import com.demo.android.alexandre.rickandmortycardapp.extensions.getTextChipChecked
import com.demo.android.alexandre.rickandmortycardapp.extensions.setButtonChecked
import com.demo.android.alexandre.rickandmortycardapp.extensions.setChipChecked
import com.demo.android.alexandre.rickandmortycardapp.ui.fragment.SharedViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_filter.*
import org.koin.android.viewmodel.ext.android.viewModel


class FilterFragment : BottomSheetDialogFragment() {
    private val viewModel: SharedViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_filter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObserver()
        setUpOnclickListener()
    }

    private fun setUpObserver() {
        viewModel.filterValue.observe(viewLifecycleOwner) {
            chipgroup_status.setChipChecked(it[0])
            radiogroup_gender.setButtonChecked(it[1])
        }
    }

    private fun setUpOnclickListener() {
        btn_make_filter.setOnClickListener {
            if (chipgroup_status.getTextChipChecked()
                    .isNotEmpty() && radiogroup_gender.getTextButtonChecked().isNotEmpty()
            ) {
                viewModel.getByStatusAndGender(
                    chipgroup_status.getTextChipChecked(),
                    radiogroup_gender.getTextButtonChecked(),
                    1
                )
            } else {
                if (chipgroup_status.getTextChipChecked().isNotEmpty()) {
                    viewModel.getByStatus(chipgroup_status.getTextChipChecked(), 1)
                } else {
                    viewModel.getByGender(radiogroup_gender.getTextButtonChecked(), 1)
                }
            }

            viewModel.filterValue.value =
                arrayOf(chipgroup_status.checkedChipId, radiogroup_gender.checkedRadioButtonId)

            findNavController().popBackStack(R.id.listFragment, false)
        }
    }
}