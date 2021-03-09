package be.vdab.personeel.services;

import be.vdab.personeel.domain.Jobtitel;
import be.vdab.personeel.repositories.JobtitelRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
class DefaultJobtitelService implements JobtitelService {
    private final JobtitelRepository jobtitelRepository;

    public DefaultJobtitelService(JobtitelRepository jobtitelRepository) {
        this.jobtitelRepository = jobtitelRepository;
    }

    @Override
    public List<Jobtitel> findAll() {
        return jobtitelRepository.findAll();
    }

    @Override
    public Jobtitel findById(long id) {
        return jobtitelRepository.findById(id).get();
    }
}
