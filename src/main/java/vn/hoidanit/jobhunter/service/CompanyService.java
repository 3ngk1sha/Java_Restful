package vn.hoidanit.jobhunter.service;

import org.springframework.stereotype.Service;

import vn.hoidanit.jobhunter.domain.Company;
import vn.hoidanit.jobhunter.repository.CompanyRepository;

import java.util.List;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company handleCreateCompany(Company c) {
        return this.companyRepository.save(c);
    }
    public List<Company> findAll() {
        return this.companyRepository.findAll();
    }

    public Company handleFindById(Company company) {
      Company c = this.companyRepository.findById(company.getId());
      if (c == null) {

          return null;
      }
      else {
          c.setName(company.getName());
          c.setAddress(company.getAddress());
          c.setDescription(company.getDescription());
          c.setLogo(company.getLogo());
          this.companyRepository.save(c);
          return c;
      }

    }

    public void deleteCompanyById(long id) {
        this.companyRepository.deleteById(id);
    }
}
