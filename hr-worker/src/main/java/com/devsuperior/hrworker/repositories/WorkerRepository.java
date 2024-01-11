package com.devsuperior.hrworker.repositories;

//--(IMPORTS)--//

import org.springframework.data.jpa.repository.JpaRepository;
import com.devsuperior.hrworker.entities.Worker;


//--(END)--//


public interface WorkerRepository extends JpaRepository<Worker, Long>{

}
