package com.abhilash.favouritedish.view.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.abhilash.favouritedish.R
import com.abhilash.favouritedish.application.FavDishApplication
import com.abhilash.favouritedish.view.activities.AddUpdateDishActivity
import com.abhilash.favouritedish.viewmodel.FavDishViewModel
import com.abhilash.favouritedish.viewmodel.FavDishViewModelFactory
import com.abhilash.favouritedish.viewmodel.HomeViewModel

class AllDishesFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    private val mFavDishViewModel: FavDishViewModel by viewModels {
        FavDishViewModelFactory((requireActivity().application as FavDishApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)

        val root: View = inflater.inflate(R.layout.fragment_all_dishes, container, false)

        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_all_dishes, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.action_add_dish -> {
                startActivity(Intent(requireActivity(), AddUpdateDishActivity::class.java))
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mFavDishViewModel.allDishesList.observe(viewLifecycleOwner) {
            dishes ->
                dishes?.let {
                    for (item in it) {
                        Log.i("DISH TITLE", "${item.id} :: ${item.title}")
                    }
                }
        }
    }

}