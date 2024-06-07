package test.test.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.test.entity.Project;


@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
