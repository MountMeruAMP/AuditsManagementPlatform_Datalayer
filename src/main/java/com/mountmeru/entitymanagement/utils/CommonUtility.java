package com.mountmeru.entitymanagement.utils;

import java.text.DecimalFormat;

import org.springframework.stereotype.Service;

@Service
public class CommonUtility {
	public static String calculateGrade(double percent_score)
	{
		String grade = new String("");
		if(100.00 >= percent_score &&  percent_score >=95.00)
		{
			grade = new String("A"); 
		}
		else if(95.00 > percent_score &&  percent_score >=80.00)
		{
			grade = new String("B"); 
		}
		else if(80.00 > percent_score &&  percent_score >=60.00)
		{
			grade = new String("C"); 
		}
		else if(0.00 == percent_score)
		{
			grade = new String("F"); 
		}
		else
		{
			grade = new String("D"); 
		}
		return grade;
	}
	public static String calculatePercentage(int numerator, int denominator)
	{
		if( 0== denominator ) return new String("0.00");
		DecimalFormat df = new DecimalFormat("##.##%");
		double percent = (numerator / denominator);
		String formattedPercent = df.format(percent);
		return formattedPercent;
	}
	
	public static String calculateGradeValue(double percent_score)
	{
		String grade = new String("");
		if(100.00 >= percent_score &&  percent_score >=95.00)
		{
			grade = new String("Very Good");
		}
		else if(95.00 > percent_score &&  percent_score >=80.00)
		{
			grade = new String("Good");
		}
		else if(80.00 > percent_score &&  percent_score >=60.00)
		{
			grade = new String("Fair");
		}
		else if(0.00 == percent_score)
		{
			grade = new String("Deficient");
		}
		else
		{
			grade = new String("Closed");
		}
		return grade;
	}

	public static Double calculateAvgScore(Integer obtainedScore, Integer maxScore) {
		if (maxScore != 0) {
			return (double) obtainedScore / maxScore * 100;
		} else {
			return 0.0;
		}
	}
}
