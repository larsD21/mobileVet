package de.vet.rest;

import de.appointment.usecase.implementation.ManageAppointment;
import de.vet.security.JWTTokenNeeded;
import de.vet.security.Role;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

// Author Lars Diekmann
@Path("image")
@Stateless
@Consumes(MediaType.APPLICATION_OCTET_STREAM)
@Produces(MediaType.APPLICATION_OCTET_STREAM)
public class ImageResource {

    @POST
    @Path("uploadImage")
    //@JWTTokenNeeded(Permissions = Role.VET)
    public Response uploadImage(InputStream imageStream) {
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
            String imagePath = imageDirectory + File.separator + imageName;
            return Response.ok(imagePath)
                    .header("Content-Disposition", "attachment; filename=\"" + imageDirectory + "/" + imageName + "\"")
                    .build();
        } catch (IOException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Fehler beim Speichern des Bildes: " + e.getMessage())
                    .build();
        }
    }
}
