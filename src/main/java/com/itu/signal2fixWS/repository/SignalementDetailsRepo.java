package com.itu.signal2fixWS.repository;

import com.itu.signal2fixWS.model.SignalementDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SignalementDetailsRepo extends JpaRepository<SignalementDetails,Long> {
    @Query(value="SELECT * FROM view_signalementdetails " +
            "WHERE (:idsignal is null or idsignalement=CAST(CAST(:idsignal AS VARCHAR) as INTEGER)) AND" +
            "(:iduser is null or iduser=CAST(CAST(:iduser AS VARCHAR) as INTEGER)) AND"+
            " (:idregion is null or idregion=CAST(CAST(:idregion AS VARCHAR) as INTEGER)) AND" +
            " (:idtype is null or idtype=CAST(CAST(:idtype AS VARCHAR) as INTEGER)) AND" +
            "(:idstatus is null or idstatus=CAST(CAST(:idstatus AS VARCHAR) as INTEGER))"
            ,nativeQuery = true)
    List<SignalementDetails> getSignalements(@Param("idsignal") final Long idSignal,@Param("iduser") final Long idUser, @Param("idregion") final Long idRegion, @Param("idtype") final Long idType, @Param("idstatus") final Long idStatus);
}
