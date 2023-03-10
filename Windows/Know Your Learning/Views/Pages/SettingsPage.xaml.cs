using Know_Your_Learning.ViewModels;
using Microsoft.UI.Xaml.Controls;

namespace Know_Your_Learning.Views.Pages;

public sealed partial class SettingsPage : Page
{
    public SettingsPage()
    {
        ViewModel = App.GetService<SettingsViewModel>();
        InitializeComponent();
    }

    public SettingsViewModel ViewModel
    {
        get;
    }
}