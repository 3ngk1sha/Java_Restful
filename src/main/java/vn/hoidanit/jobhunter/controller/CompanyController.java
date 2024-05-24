package vn.hoidanit.jobhunter.controller;

import com.turkraft.springfilter.boot.Filter;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.hoidanit.jobhunter.domain.Company;
import vn.hoidanit.jobhunter.domain.dto.ResultPaginationDTO;
import vn.hoidanit.jobhunter.service.CompanyService;
import vn.hoidanit.jobhunter.util.error.IDInvalidException;

import java.util.List;

@RestController
public class CompanyController {
    private final CompanyService companyService;
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }
    @PostMapping("companies")
    public ResponseEntity<Company> createCompany( @RequestBody @Valid Company company) {
        return  ResponseEntity.ok(this.companyService.handleCreateCompany(company));

    }

    @GetMapping("companies")
    public ResponseEntity<ResultPaginationDTO> listAllCompanies(
            @Filter Specification<Company> specification,
            Pageable pageable
    ) {
        return ResponseEntity.ok(this.companyService.findAll(specification,pageable));
    }

    @PutMapping("companies")
    public ResponseEntity<Company> updateCompany(@Valid @RequestBody Company company)  {
     Company c = this.companyService.handleFindById(company);
     return ResponseEntity.ok(c);
    }

    @DeleteMapping("companies/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable("id") long id) {
    this.companyService.deleteCompanyById(id);
    return ResponseEntity.ok(null);
    }

}

