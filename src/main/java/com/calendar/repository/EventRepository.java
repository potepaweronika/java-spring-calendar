package com.calendar.repository;

import com.calendar.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
//    @Query("select events from Event events  ")
//    Collection<Event> findAllForUser(User user);

}
