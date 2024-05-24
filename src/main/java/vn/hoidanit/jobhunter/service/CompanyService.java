package vn.hoidanit.jobhunter.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import vn.hoidanit.jobhunter.domain.Company;
import vn.hoidanit.jobhunter.domain.dto.MetaDTO;
import vn.hoidanit.jobhunter.domain.dto.ResultPaginationDTO;
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


    public ResultPaginationDTO findAll(Specification<Company> spec, Pageable pageable) {
        Page<Company> companies = companyRepository.findAll(spec, pageable);

        ResultPaginationDTO resultPaginationDTO = new ResultPaginationDTO();
        MetaDTO meta = new MetaDTO();

        meta.setPage(pageable.getPageNumber());
        meta.setPageSize(pageable.getPageSize());
        meta.setPages(companies.getTotalPages());
        meta.setTotalPages(companies.getTotalPages());

        resultPaginationDTO.setMeta(meta);
        resultPaginationDTO.setResult(companies.getContent());
        return resultPaginationDTO;
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
