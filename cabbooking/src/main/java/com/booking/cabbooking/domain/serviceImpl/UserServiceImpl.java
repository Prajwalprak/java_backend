package com.booking.cabbooking.domain.serviceImpl;

import com.booking.cabbooking.domain.Repository.UserRepo;
import com.booking.cabbooking.domain.exception.CsvValidationException;
import com.booking.cabbooking.domain.model.Users;
import com.booking.cabbooking.domain.model.UserCsvRecord;
import com.booking.cabbooking.domain.service.UserService;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();


    @Override
    public int uploadCsv(MultipartFile file) {
        List<Users> validUser = new ArrayList<>();

        try(Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))){

//            String headerLine = br.readLine();
//            System.out.println("CSV Header line: " + headerLine);

            HeaderColumnNameMappingStrategy<UserCsvRecord> strategy = new HeaderColumnNameMappingStrategy<>();
            strategy.setType(UserCsvRecord.class);

            CsvToBean<UserCsvRecord> csvToBean = new CsvToBeanBuilder<UserCsvRecord>(reader)
                    .withMappingStrategy(strategy)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

//            CsvToBean<UserCsvRecord> csvToBean = new CsvToBeanBuilder<UserCsvRecord>(
//                    new CSVReaderBuilder(reader)
//                            .withCSVParser(new CSVParserBuilder().build())
//                            .build())
//                    .withMappingStrategy(strategy)
//                    .withIgnoreLeadingWhiteSpace(true)
//                    .build();

            for(UserCsvRecord record : csvToBean){

                System.out.println("Parsed Record: " + record);

                Set<ConstraintViolation<UserCsvRecord>> violations = validator.validate(record);
                if(violations.isEmpty()){
                    validUser.add(mapToEntity(record));
                }else {
                    log.warn("Invalid row skipped: {}", violations.stream().map(ConstraintViolation::getMessage).toList());
                }
            }

        } catch (Exception e) {
            throw new CsvValidationException("Error parsing CSV : " + e);
        }

        userRepo.saveAll(validUser);
        return validUser.size();
    }

    private Users mapToEntity(UserCsvRecord record) {
        return Users.builder()
                .name(record.getName())
                .college(record.getCollege())
                .location(record.getLocation())
                .companyName(record.getCompanyName())
                .companyLocation(record.getCompanyLocation())
                .build();
    }
}




