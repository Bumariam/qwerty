package com.example.alcohol

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer

class Profile : Fragment() {

    private lateinit var textViewWater: TextView
    private lateinit var textViewPills: TextView
    private lateinit var textViewFood: TextView
    private lateinit var textViewSleep: TextView
//    private lateinit var waterProgressBar: ProgressBar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_profile, container, false)
        requireContext()
        textViewWater = rootView.findViewById(R.id.water_prof)
        textViewPills = rootView.findViewById(R.id.pills_prof)
        textViewFood = rootView.findViewById(R.id.food_prof)
        textViewSleep = rootView.findViewById(R.id.sleep_prof)
//        textViewStepsBig = rootView.findViewById(R.id.steps_big) для трекера воды
//        stepsProgressBar = rootView.findViewById(R.id.stepsProgressBar) для трекера воды
//        stepsProgressBar.max = fitnessViewModel.loadObjectiveSteps(rootView.context)



        return rootView
    }

}