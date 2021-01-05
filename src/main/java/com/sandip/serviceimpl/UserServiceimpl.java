package com.sandip.serviceimpl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import com.sandip.entity.User;
import com.sandip.repository.UserReporsitory;
import com.sandip.service.UserService;

@Service
@EnableAsync
public class UserServiceimpl implements UserService {
	
	@Autowired
	private UserReporsitory userReporsitory; 

	@Override
	public List<User> save(InputStream is) throws Exception {
		List<User> userList = new ArrayList<User>();
		Workbook workbook = new XSSFWorkbook(is);

		// Getting the Sheet at index zero
		Sheet sheet = workbook.getSheetAt(0);
		sheet.removeRow(sheet.getRow(0));

		// Create a DataFormatter to format and get each cell's value as String
		DataFormatter dataFormatter = new DataFormatter();


		for (Row row : sheet) {
			User userData = new User();
			userData.setFirstname(row.getCell(0).toString());
			userData.setLastname(row.getCell(1).toString());
			userData.setUsername(row.getCell(2).toString());
			userData.setPassword(row.getCell(3).toString());
			userData.setEmail(row.getCell(4).toString());
			userData.setMobileNo(dataFormatter.formatCellValue(row.getCell(5)));
			userData.setCreatedon(new Date());
			
			userList.add(userData);
		}


		// Closing the workbook
		workbook.close();
		
		return userReporsitory.saveAll(userList);
	}


}
