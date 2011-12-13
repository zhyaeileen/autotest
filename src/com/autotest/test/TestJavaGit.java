package com.autotest.test;

import java.io.File; 
import java.io.IOException;

import edu.nyu.cs.javagit.api.DotGit;
import edu.nyu.cs.javagit.api.JavaGitConfiguration;
import edu.nyu.cs.javagit.api.JavaGitException;
import edu.nyu.cs.javagit.api.Ref;
import edu.nyu.cs.javagit.api.WorkingTree;

public class TestJavaGit {
public static void main(String[] args) {   
	try {  
			// Print the git version:  1.5.1
			System.out.println(JavaGitConfiguration.getGitVersion()); 
	} catch (JavaGitException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();}
//	}catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//	}
	 

	
	// Create a new directory to be used as a git repository or point to an exisiting directory.
	File repositoryDirectory = new File("D:\\workspaces\\autotest\\javagittest");

	//get the instance of the dotGit Object
	DotGit dotGit = DotGit.getInstance(repositoryDirectory);

	//Initialize the repository ,similar to git init
	dotGit.init();
	 
	// Get the current working tree from the git repository
	WorkingTree wt = dotGit.getWorkingTree();
	// Getting the current working branch
	Ref master;
	try {
		master = wt.getCurrentBranch();
	 
		// Print the name of the current branch, "master" in this case
		System.out.println("Current branch is:  " + master);

	 
		// Creating a new branch 
		Ref experimental;
		experimental = dotGit.createBranch("experimental");
		wt.checkout(experimental);

		 
		// Print the name of the current branch, now it is "experimental"
		System.out.println("Current branch is:  " + wt.getCurrentBranch());

		// Deleting a branch, remember to change the current branch
		wt.checkout(master);
		dotGit.deleteBranch(experimental, true);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (JavaGitException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
