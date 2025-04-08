package br.com.app.api.commom;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

public abstract class BaseControllerTest {

    protected abstract MockMvc getMockMvc();

    private final String AUTHORIZATION = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJ0ZWNoIjoiYW5kcm9pZCIsInNjcCI6WyJhY2Nlc3MiXSwidmVyIjoiMS4wIiwieC1zdGF0ZWxlc3MtY2xvc2VkIjoiZXlKaGJHY2lPaUpGUTBSSUxVVlRJaXdpWlc1aklqb2lRVEV5T0VkRFRTSXNJbXRwWkNJNkltUTJPRE5qTXpZMExXSmtZamd0TkRFd1pTMWhNR1V5TFRNNE0yRXpOMkZpTnpWaU1pSXNJbVZ3YXlJNmV5SnJkSGtpT2lKRlF5SXNJbmdpT2lJd05EVTVWWFowTTBKeGR5MVdja3RpVjFrM1dHWnhkMHAzVW1Vd2JXY3pXRE5TVWpGaU9WTlNVV1ZSSWl3aWVTSTZJbE5MYzJKRFEwOXNNRkZEVUZGblkwODNVMHRLU1dRek5IUnFSbTVRWW1kdVFXSlBlbmRXYkhGRlFsVWlMQ0pqY25ZaU9pSlFMVEkxTmlKOWZRLi5QSTVvdW5xV3YyMm9PVFFFLlgwRnZmNzA4UjRzSlRyWm9udW9IaFE5clVVY0ZSMGJobHdHRWhMTTFkb3RMdVJhbERDY1B4b2EzY0JMc1hIWnQ3ZmpubHhURkVZc3NXZjJydXFQQU1UNnA0Ni1xbG9ON21KTzE0NWc0ekZMN1ExUFU3dlFiTkFHM08xek5HWU9EbWxSSjlnYlBDdm8tVUZYQzBaT3dXQncybm5UbnpwMTlsSnpuLS1aeld1YU0zQzQwWHU1TGlOR3Q4TUZSYTJPVXo4UzRKQ3VYZzlqNzlMaERDanhpU21TUDBUTjFQWHF0dU1aOXo1dEJPNGtfdDIxcTEySzZvUHBXSHF5US50UHhfLW9DZlVNeWJ2eDVOdkhxa05nIiwiYXV0aERhdGEiOiJURTdzc3U5UEdIMlZoc1kxS0ZDRW9BR2oxdG44VXNZVFc0bjh6dVhnY3dJSmxLRldxVXZYY2piT1ZLb2RvalB4UjZ2dDZhZ2Vva2Y1OGRMR1VDQ284c3BId0lYVUR4UzE3eVNiRUE3Yk43d0NzdnNSK2cwMXJUWXZxWCthZHdOSkVneThQcnRDUitsWFlCd0NKaG4zczNyK3E2N1BGMzhFSEJwbUdSdXJuMXVQTkV2cjl2RFEyN1BOWkNJSmdtREx5WlNINkV3WWF4QjRzb0JQQ1kxVUd2QXBjdlJrbTlTaVZURWFFSDNJdVEzNVIrdXpCajJhVnIwSHc2ckU1VGFvaEVPdDlEUHZVazgvZXJYaEpoWldwTklSVXUxcVhDL0pLSjVIUG1yaGtzOS9mVlg4Uk1DMXhXMm9SNmhuMmpldDhTTGV4dUNOaXlna1g1UGFGaDRhaVE9PSIsIngtc3RhdGVsZXNzLW9wZW4iOiJleUpoYkdjaU9pSkZVekkxTmlJc0ltdHBaQ0k2SW1RMk9ETmpNelkwTFdKa1lqZ3ROREV3WlMxaE1HVXlMVE00TTJFek4yRmlOelZpTWlKOS5leUpqYkdsbGJuUmxJanA3SW5ScGRIVnNZWEpwWkdGa1pTSTZJakVpTENKa1lXTWlPaUk1SWl3aVkyOXVkR0VpT2lJeU56YzFOREFpTENKamNHWkRibkJxSWpvaU56Z3pOelk0TnpRMU1EQXdNREF3SWl3aWNtRjZZVzhpT2lJd056QTFJaXdpWVdkbGJtTnBZU0k2SWpNNU9UVWlMQ0p3YWpBd0lqcG1ZV3h6Wlgwc0luQmxjbWxtWlhKcFkyOGlPaUkwT1RReU9UazNNRGMzTkRFM01URWlMQ0pwWkdsdmJXRWlPakVzSW1OaGJtRnNJam8yTml3aVpXMXdjbVZ6WVNJNk1qTTNMQ0oxZFdsa0lqb2laV0pqWVdWa05qSXRNVEptTnkwME1XVmhMV0UxWm1RdE1HSTRZemczWXpka05XWXhJaXdpWkdWd1pXNWtaVzVqYVdFaU9qRjkuY3BjcjBzTV9tVzlBNTBlTU51ZnJUNzNHWVVaOVB2cm1MVHpwamRkM1RSd282TlByR085eVB5VTZjQkE4RGdyZThXNHhmZW43ampzT0tNblB1VXc0WnciLCJqdGkiOiI0OTQyOTk3MDc3NDE3MTEwMDAiLCJpc3MiOiJodHRwczovL2JjcGYuYnJhZGVzY28uY29tLmJyIiwiYXVkIjoiaHR0cHM6Ly9iY3BmLmJyYWRlc2NvLmNvbS5ici9hcGkiLCJleHAiOjE2NzQ4NDY4NzZ9.VAlhkSv35213-slqxN3y3f1TzXlgXY4eZMmvcff1oOxkXHUON4dF06LA6rqFMhr4cVCjE2LMqYlHnmKiLqNTwQ";

    protected RequestBuilder asyncGetRequest(String url) throws Exception {
        return asyncDispatch(getMockMvc().perform(get(url)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(request().asyncStarted())
                .andReturn());
    }

    protected RequestBuilder asyncPostRequest(String url, String payload) throws Exception {
        // @formatter:off
        return asyncDispatch(
                getMockMvc().perform(
                                post(url).header("Authorization",AUTHORIZATION)
                                        .content(payload)
                                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(request().asyncStarted())
                        .andReturn());
        // @formatter:on
    }
}
