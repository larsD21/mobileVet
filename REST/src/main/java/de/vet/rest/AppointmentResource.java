package de.vet.rest;

import de.appointment.entity.AppointmentTO;
import de.vet.security.JWTTokenNeeded;
import de.vet.security.Role;
import de.appointment.usecase.IGetAppointment;
import de.appointment.usecase.IManageAppointment;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

//Author Lars Diekmann

@Path("appointment")
@Stateless
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AppointmentResource {
    @Inject
    IManageAppointment manageAppointment;

    @Inject
    IGetAppointment getAppointment;

    @POST
    @Path("create")
    @JWTTokenNeeded(Permissions = Role.VET)
    public Response createAppointment(AppointmentTO appointment){
        manageAppointment.createAppointment(appointment);
        return Response.ok().build();
    }

    @POST
    @Path("uploadImage")
    @Consumes(MediaType.APPLICATION_OCTET_STREAM)
    @JWTTokenNeeded(Permissions = Role.VET)
    public Response uploadImage(InputStream imageStream){
        String imageDirectory = "/home/mattern/Dokumente/images";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmssSSS");
        String imageName = "image_" + dateFormat.format(new Date()) + ".png";

        try {
            File file = new File(imageDirectory, imageName);
            try (OutputStream outputStream = new FileOutputStream(file)) {
                int bytesRead;
                byte[] buffer = new byte[1024];
                while ((bytesRead = imageStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
            }
            String imagePath = imageDirectory + imageName;
            return Response.ok(imagePath).build();
        } catch (IOException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Fehler beim Speichern des Bildes").build();
        }
    }

    @POST
    @Path("edit")
    @JWTTokenNeeded(Permissions = Role.VET)
    public Response editAppointment(AppointmentTO appointment){
        manageAppointment.editAppointment(appointment);
        return Response.ok().build();
    }

    @GET
    @Path("getAll")
    @JWTTokenNeeded(Permissions = Role.VET)
    public List<AppointmentTO> getAllAppointment(){
        return getAppointment.getAllAppointments();
    }
}
