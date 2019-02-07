package com.Library.service;

import com.Library.dao.LibraryBranchDao;
import com.Library.model.LibraryBranch;
import com.Library.util.ConnectDatabase;

public class LibraryBranchService {

	LibraryBranchDao libraryBranchDao = new LibraryBranchDao();

	public void updateLibraryBranchName(int branchId, String branchName) {

		libraryBranchDao.updateLibraryBranchNameByBranchId(ConnectDatabase.getConnection(), branchId, branchName);

	}

	public void getAllBranches() {

		libraryBranchDao.getAllBranches(ConnectDatabase.getConnection());
	}

	public int getBranchId() {

		return libraryBranchDao.getBranchId(ConnectDatabase.getConnection());
	}

	public int retrieveBranchId(int branchId) {

		return libraryBranchDao.getLibraryBranchId(ConnectDatabase.getConnection(), branchId);
	}

	public String getBranchName(int branchId) {

		return libraryBranchDao.getLibraryBranchNameById(ConnectDatabase.getConnection(), branchId);

	}

	public void getBranchAddress(int branchId, String branchAddress) {

		libraryBranchDao.updateLibraryBranchAddressByBranchId(ConnectDatabase.getConnection(), branchId, branchAddress);
	}
	
	public String getBranchAddress(int branchId) {
		
		return libraryBranchDao.getLibraryBranchAddressById(ConnectDatabase.getConnection(), branchId);
	}
	
}
