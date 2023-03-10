namespace Know_Your_Learning.Contracts.Services;

public interface IActivationService
{
    Task ActivateAsync(object activationArgs);
}